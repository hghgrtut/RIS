using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json;
using System.Threading.Tasks;

namespace Alexander
{
    public class ObjectSerializable
    {
        public async void SerializableToFile(String nameFile, Disk disk)
        {
            FileStream fileStream = new FileStream(nameFile + ".json", FileMode.OpenOrCreate);
            await JsonSerializer.SerializeAsync(fileStream, disk);
            await fileStream.DisposeAsync();
        }

        public Disk DeserializeFromFile(String nameFile)
        {
            FileStream fileStream = new FileStream(nameFile + ".json", FileMode.Open);
            Disk? disk = JsonSerializer.Deserialize<Disk>(fileStream);
            fileStream.Dispose();
            if (disk != null)
            {
                return disk;
            }
            else
            {
                throw new IOException("Object is null");
            }
        }
    }
}