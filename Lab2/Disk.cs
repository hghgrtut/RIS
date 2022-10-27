using System.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Alexander
{
    [Serializable]
    public class Disk
    {
        public string Name {get; set;}
        public double Memory {get; set;}
        public Format Format {get; set;}
        public List<Music> Musics {get;}

        public Disk(string name, double memory, Format format)
        {
            this.Name = name;
            this.Memory = memory;
            this.Format = format;
            this.Musics = new List<Music>();
        }

        public void RecordMusic(Music music)
        {
            double AllMemory = 0;
            foreach (var mus in Musics)
            {
                AllMemory += mus.Memory;
            }

            if(AllMemory < Memory)
            {
                Musics.Add(music);
            }
        }

        public void DeleteMusic(Music music)
        {
            Musics.Remove(music);
        }

        public int GetMusicsTime()
        {
            int minutes = 0;
            foreach (var mus in Musics)
            {
                minutes += mus.Duration.Minute;
            }
            return minutes;
        }
    }
}