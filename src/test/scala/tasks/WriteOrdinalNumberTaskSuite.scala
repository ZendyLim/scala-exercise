package tasks

import munit.Clue.generate

class WriteOrdinalNumberTaskSuite extends munit.FunSuite {
  test("should return '1st' on input 1") {
    assertEquals(WriteOrdinalNumberTask(1).result, "1st")
  }

  test("should return '2nd' on input 2") {
    assertEquals(WriteOrdinalNumberTask(2).result, "2nd")
  }

  test("should return '3rd' on input 3") {
    assertEquals(WriteOrdinalNumberTask(3).result, "3rd")
  }

  test("should return '4th' on input 4") {
    assertEquals(WriteOrdinalNumberTask(4).result, "4th")
  }

  test("should return '11th' on input 11") {
    assertEquals(WriteOrdinalNumberTask(11).result, "11th")
  }
}

