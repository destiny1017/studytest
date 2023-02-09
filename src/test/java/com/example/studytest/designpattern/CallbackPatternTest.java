package com.example.studytest.designpattern;

import org.junit.jupiter.api.Test;

import java.io.File;

public class CallbackPatternTest {

    class Excel {}
    class Docs {}
    class PPT {}
    class FileContents{}


    public class GeneratorContext<T> {

        public T conversion(String path, GeneratorStrategy strategy) {
            T generatedFile;
            File file = new File(path);
            FileContents contents = readFileContents(file);
            generatedFile = (T) strategy.generate(contents); // 개별로직 부분은 추상 메서드를 호출하도록
            return generatedFile;
        }

        FileContents readFileContents(File file) {
            return new FileContents();
        }

    }

    public interface GeneratorStrategy<T> {
        T generate(FileContents contents);
    }

    public class ExcelGeneratorStrategy implements GeneratorStrategy<Excel> {
        @Override
        public Excel generate(FileContents contents) {
            //
            // .. contents분석 및 Excel 변환 로직..
            //
            return new Excel();
        }
    }

    public class DocsGeneratorStrategy implements GeneratorStrategy<Docs> {
        @Override
        public Docs generate(FileContents contents) {
            //
            // .. contents분석 및 Docs 변환 로직..
            //
            return new Docs();
        }
    }

    public class PPTGeneratorStrategy implements GeneratorStrategy<PPT> {
        @Override
        public PPT generate(FileContents contents) {
            //
            // .. contents분석 및 Excel 변환 로직..
            //
            return new PPT();
        }
    }

    @Test
    void strategyTest() {
        GeneratorStrategy excelGeneratorStrategy = new ExcelGeneratorStrategy();
        GeneratorStrategy docsGeneratorStrategy = new DocsGeneratorStrategy();
        GeneratorStrategy pptGeneratorStrategy = new PPTGeneratorStrategy();

        GeneratorContext generatorContext = new GeneratorContext<>();


        System.out.println("generatorContext1.conversion(\"D:/test\") = " + generatorContext.conversion("D:/test", excelGeneratorStrategy));
        System.out.println("generatorContext1.conversion(\"D:/test\") = " + generatorContext.conversion("D:/test", docsGeneratorStrategy));
        System.out.println("generatorContext1.conversion(\"D:/test\") = " + generatorContext.conversion("D:/test", pptGeneratorStrategy));

    }

}
