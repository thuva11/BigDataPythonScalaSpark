# # next we create the implementation class, but leave the methods blank for now (we do this so we can call the methods in the tests we will create without the IDE screaming at us). Also, we will want to have a custom exception with our calculator, so we need to create that as well
# from interface.calculator import Calculator
# class CalculatorImp(Calculator):
    # def addition(self, num1: int, num2: int) -> int:
        # pass

    # def subtraction(self, num1: int, num2: int) -> int:
        # pass

    # def rounding(self, result: float) -> int:
        # pass
        
import numbers
from custom_exceptions.custom_exception import CustomException
from interface.calculator import Calculator


class CalculatorImp(Calculator):
    def addition(self, num1: int, num2: int) -> int:
        if isinstance(num1, numbers.Number) and isinstance(num2, numbers.Number): # this checked to make sure the input is of the numeric type
            result = num1 + num2
            return result
        else:
            raise CustomException("One or more entries were not numeric") # we want this message to match the test

    def subtraction(self, num1: int, num2: int) -> int:
        if isinstance(num1, numbers.Number) and isinstance(num2, numbers.Number):# this checked to make sure the input is of the numeric type
            result = num1 - num2
            return result
        else:
            raise CustomException("One or more entries were not numeric")# we want this message to match the test

    def rounding(self, result: float) -> int:
        if isinstance(result, numbers.Number):# this checked to make sure the input is of the numeric type
            return round(result) # the round method takes in a second value that determines to what decimal place you want the number rounded
        else:
            raise CustomException("Could not round the value")# we want this message to match the test