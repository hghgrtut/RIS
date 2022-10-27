using System.Data;
using Alexander;

Music firstMusic = new("Alexis Ffrench", "Still Life", GenreMusic.Classical, new DateTime().AddMinutes(3).AddSeconds(23), 25);
Music secondMusic = new("Black Coffee", "Mary Juane Clair", GenreMusic.Jazz, new DateTime().AddMinutes(3).AddSeconds(29), 30);

Disk disk = new("Music collection", 50, Format.MP3);
disk.RecordMusic(firstMusic);
disk.RecordMusic(secondMusic);
Console.WriteLine(disk.GetMusicsTime());

ObjectSerializable objectSerializable = new();

objectSerializable.SerializableToFile("test", disk);
Disk newDisk = objectSerializable.DeserializeFromFile("test");
