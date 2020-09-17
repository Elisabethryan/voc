#import sys

#sys.path.append("..")

from ..utils import TranspileTestCase

class MathModuleTests(TranspileTestCase):
    def test_floor(self):
        self.assertCodeExecution("""
            import math
            print(math.fabs(-5))
        """)
