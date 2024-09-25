import unittest
import skeleton_test

if __name__ == "__main__":
    suite = unittest.TestLoader().loadTestsFromModule(skeleton_test)
    result = unittest.TestResult()
    suite.run(result, debug=True)
    print(f"{result=}")
