using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GrpcServer.Models
{
    public class Person
    {
        public string name {get; set;}
        public string surname {get; set;}

        public Person(string name, string surname)
        {
            this.name = name;
            this.surname = surname;
        }
    }
}