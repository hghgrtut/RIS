using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Text.Json;

namespace ammunition
{
    public class ObjectSerializable
    {
        public async void SerializableToFile(String nameFile, Motorcyclist motorcyclist)
        {
            FileStream fileStream = new FileStream(nameFile+ ".json", FileMode.OpenOrCreate);
            await JsonSerializer.SerializeAsync(fileStream, motorcyclist);
            await fileStream.DisposeAsync();
        }

        public Motorcyclist DeserializeFromFile(String nameFile)
        {
           FileStream fileStream = new FileStream(nameFile + ".json", FileMode.Open);
           Motorcyclist? motorcyclist = JsonSerializer.Deserialize<Motorcyclist>(fileStream);
           fileStream.Dispose();
           if(motorcyclist != null)
            {
                return motorcyclist;
            }
            else
            {
                throw new ArgumentNullException();
            }
        }
    }
}