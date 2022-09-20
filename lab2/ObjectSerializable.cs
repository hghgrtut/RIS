using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Text.Json;

namespace lab2
{
    public class ObjectSerializable
    {
        public async void SerializableToFile(String nameFile, Train train)
        {
            FileStream fileStream = new FileStream(nameFile+ ".json", FileMode.OpenOrCreate);
            await JsonSerializer.SerializeAsync(fileStream, train);
            await fileStream.DisposeAsync();
        }

        public Train DeserializeFromFile(String nameFile)
        {
           FileStream fileStream = new FileStream(nameFile + ".json", FileMode.Open);
           Train? train = JsonSerializer.Deserialize<Train>(fileStream);
           fileStream.Dispose();
           if(train != null)
           {
            return train;
           }
           else
           {
            throw new IOException();
           }

        }
    }
}