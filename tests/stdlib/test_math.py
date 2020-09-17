from unittest import expectedFailure

from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):

    #######################################################
    def test_floor_positive_value(self):
        self.assertCodeExecution("""
            import math
            print(math.floor(3.4))
            """)

    #######################################################
    def test_floor_negative_value(self):
        self.assertCodeExecution("""
        import math
        print(math.floor(-14.5))
        """)

    #######################################################
    @expectedFailure
    def test_floor_string(self):
            self.assertCodeExecution("""
                import math
                print(math.floor("test string"))
                """)
