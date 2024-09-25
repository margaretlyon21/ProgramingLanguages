from typing import Dict, Any, Iterator, Optional
from collections import abc
from types import FunctionType
import inspect


#the dynamic scope class, a custom disctionary
class DynamicScope(abc.Mapping):
    def __init__(self):
        self.env: Dict[str, Optional[Any]] = {}

    #checks if the item is in the dictionary and returns it 
    def __getitem__(self, k):
        if k in self.env:
            return self.env[k]
        else:
            raise NameError(f"Name '{k}' is not defined.")

    #If we dont have these methods, we will be given the default versions which
    #wont work for our class
    def __iter__(self):
        return iter(self.env)

    def __len__(self):
        return len(self.env)


#gets the dynamic scope object associated with a current frame
def get_dynamic_re() -> DynamicScope:
    #instantiates a stack object and a DynamicScope object
    stack = inspect.stack()
    dynamo = DynamicScope()
    #instantiates a dictionary that will be filled with stack variables
    dictionary = {}

    #iterates through items in the stack 
    for item in stack[1:]:
        #gets the local varaibles from the current stack frame
        currFrame = item.frame
        localVars = currFrame.f_locals
        
        #gets the free vars
        freeVars = currFrame.f_code.co_freevars

        #if the local variable is not already in the dictionary, add it
        for key, value in localVars.items():
            if key not in dictionary and key not in freeVars:
                dictionary[key] = value
        
    #assign the contents of the dictionary to the DynamicScope object
    dynamo.env = dictionary
    return dynamo
