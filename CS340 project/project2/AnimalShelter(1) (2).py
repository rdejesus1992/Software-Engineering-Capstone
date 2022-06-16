from pymongo import MongoClient
from bson.objectid import ObjectId

class AnimalShelter(object):
    """ CRUD operations for Animal collection in MongoDB """

    def __init__(self, username,password):
        # Initializing the MongoClient. This helps to 
        # access the MongoDB databases and collections. 
        self.client = MongoClient('mongodb://%s:%s@localhost:30875/AAC'%('aacuser','2468'))
        self.database = self.client['AAC']
        

# Complete this create method to implement the C in CRUD.
    def create(self, data):
        if data is not None:
            self.database.animals.insert(data)  # data should be dictionary
            return True
        else:
            raise Exception("Nothing to save, because data parameter is empty")
            return False

# Create method to implement the R in CRUD.
    def read(self, searchData):
        if searchData:
            data = self.database.animals.find(searchData, {"_id": False})
        else:
            data = self.database.animals.find( {}, {"_id": False})
        # Return the dataset else let the error flow up
        return data
    
# Create method to implement the U in CRUD.
    def update(self, searchData, updateData):
        if searchData is not None:
            result = self.database.animals.update_many(searchData, { "$set": updateData })
        else:
            return "{}"
        # Return the dataset else let the error flow up
        return result.raw_result

# Create method to implement the D in CRUD.
    def delete(self, deleteData):
        if deleteData is not None:
            result = self.database.animals.delete_many(deleteData)
        else:
            return "{}"
        # Return the dataset else let the error flow up
        return result.raw_result