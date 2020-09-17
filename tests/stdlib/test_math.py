from .. import utils

class MathModuleTests(utils.TranspileTestCase):
    def test_abs(self):
        self.assertCodeExecution("""
            import math
            print(math.abs(-5))
        """)
