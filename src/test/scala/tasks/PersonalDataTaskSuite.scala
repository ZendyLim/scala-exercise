package tasks

import munit.Clue.generate

class PersonalDataTaskSuite extends munit.FunSuite {
  test("should return '+**-***-****-1111' on input '+11 111 1111 1111'") {
    assertEquals(PersonalDataTask.initialize("+11 111 1111 1111").result, "+**-***-****-1111")
  }

  test("should return '+**-***-***1-111' on input '+11 111 1111 111'") {
    assertEquals(PersonalDataTask.initialize("+11 111 1111 111").result, "+**-***-***1-111")
  }

  test("should return '**-***-****-1111' on input '11 111 1111 1111'") {
    assertEquals(PersonalDataTask.initialize("11 111 1111 1111").result, "**-***-****-1111")
  }

  test("should return '**-***-***1-111' on input '11 111 1111 111'") {
    assertEquals(PersonalDataTask.initialize("11 111 1111 111").result, "**-***-***1-111")
  }

  test("should return 'a*****n@example.com' on input 'admin@example.com'") {
    assertEquals(PersonalDataTask.initialize("admin@example.com").result, "a*****n@example.com")
  }

  test("should return 's*****t@example.com' on input 'support@example.com'") {
    assertEquals(PersonalDataTask.initialize("support@example.com").result, "s*****t@example.com")
  }

  test("should return 'n*****n@example.com' on input 'n@example.com'") {
    assertEquals(PersonalDataTask.initialize("n@example.com").result, "n*****n@example.com")
  }

  test("should return 'a*****n@example.com' on input 'ADMIN@example.com'") {
    assertEquals(PersonalDataTask.initialize("ADMIN@example.com").result, "a*****n@example.com")
  }

  test("should throw IllegalArgumentException when initialized with not email or phone") {
    interceptMessage[IllegalArgumentException]("Data is not a phone number or email.") {
      PersonalDataTask.initialize("John Doe")
    }
  }
}

