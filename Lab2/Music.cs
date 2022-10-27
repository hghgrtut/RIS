using System.Diagnostics;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Alexander
{
    [Serializable]
    public class Music
    {
        public string Name {get; set;}
        public string Author {get; set;}
        
        public GenreMusic GenreMusic {get; set;}

        public DateTime Duration {get; set;}
        public double Memory {get; set;}

        public Music(string name, string author, GenreMusic genreMusic, DateTime duration, double memory)
        {
            this.Name = name;
            this.Author = author;
            this.GenreMusic = genreMusic;
            this.Duration = duration;
            this.Memory = memory;
        }
    }
}