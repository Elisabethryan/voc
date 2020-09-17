from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    def test_ceil_positive_value(self):
        self.assertCodeExecution("""
            import math
            print(math.ceil(3.4))
            """)
            
    def test_ceil_negative_value(self):
        self.assertCodeExecution("""
            import math
            print(math.ceil(-14.5))
            """)
