using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace lab2
{
    [Serializable]
    public class Bag
    {
        public string id {get; set;}
        
        public Person person {get; set;}

        public Bag(Person person)
        {
            this.id = Guid.NewGuid().ToString();
            this.person = person;
        }
    }
}