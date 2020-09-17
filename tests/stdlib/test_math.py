from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    def test_floor(self):
        self.assertCodeExecution("""
            import math
            print(math.abs(-5))
        """)
