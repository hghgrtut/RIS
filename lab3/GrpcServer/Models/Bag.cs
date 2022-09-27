using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GrpcServer.Models
{
    public class Bag
 {
        public Person person {get; set;}

        public Bag(Person person)
        {
            this.person = person;
        } 
    }
}