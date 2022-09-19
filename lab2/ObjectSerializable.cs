using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Text.Json;

namespace lab2
{
    public class ObjectSerializable
    {
        public void SerializableToFile(String nameFile, Train train)
        {
            FileStream fileStream = new FileStream(nameFile + ".json", FileMode.OpenOrCreate);
            JsonSerializer.Serialize(fileStream, train);
        }

        public Train DeserializeFromFile(String nameFile)
        {
            FileStream fileStream = new FileStream(nameFile + ".json", FileMode.OpenOrCreate);
            Train train = JsonSerializer.Deserialize<Train>(fileStream);
            if(train != null)
            {
                return train;
            }
            else
            {
                throw new ArgumentNullException();
            }
        }
    }
}