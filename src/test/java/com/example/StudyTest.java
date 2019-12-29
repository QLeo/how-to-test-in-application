package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("스터디 만들기 :)")
    @FastTest
    void create_new_study() {
        Study study = new Study(-10);


        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () ->"스터디를 처음 만들면 처음 상태값이 DRAFT여야 한다"),
                () -> assertTrue(study.getLimit() > 10)
        );

//        assertNotNull(study);
        // 성공/실패 모두 메시지를 실행
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 처음 상태값이 DRAFT여야 한다");

        // 실패할 때만 리턴값을 출력한다
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), () ->"스터디를 처음 만들면 처음 상태값이 DRAFT여야 한다");

        /*assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
            @Override
            public String get() {
                return "스터디를 처음 만들면 처음 상태값이 DRAFT여야 한다";
            }
        });*/


    }

    @Test
    void create_new_study_1() {
        IllegalArgumentException illegalArgumentException =
                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("아놔 10보다 작다고", illegalArgumentException.getMessage());
    }


    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("스터디 만들기")
//    @ParameterizedTest
    @ParameterizedTest(name = "{index} {displayName} {0}")
    @ValueSource(strings = {"날씨가", "많이", "춥다"})
    void parameterizedTest(String message) {
        System.out.println(message);
    }


    @Test
    void assumeTest() {
        //assumeTrue()
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}
