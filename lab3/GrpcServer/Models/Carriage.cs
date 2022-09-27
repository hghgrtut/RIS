using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GrpcServer.Models
{
    public class Carriage
    {
         public string typeCarriage {get; set;}
        public int maxPlace {get; set;}
        public int maxBag {get; set;}
        public List<Person> people {get;}
        public List<Bag> bags {get;}

        public Carriage(string typeCarriage, int maxPlace, int maxBag)
        {
            this.typeCarriage = typeCarriage;
            this.maxPlace = maxPlace;
            this.maxBag = maxBag;
            this.people = new List<Person>();
            this.bags = new List<Bag>();
        }

        public bool RegistrationPerson(Person person)
        {
            if(people.Capacity < maxPlace)
            {
                people.Add(person);
                return true;
            }
            else 
            {
                throw new IndexOutOfRangeException("Limit exceeded");
            }
        }

        public bool RefuseRegistrationPerson(Person person)
        {
            if(people.Contains(person))
            {
                people.Remove(person);
                return true;
            }
            else
            {
                throw new DllNotFoundException("Object not found");
            }
        }

        public bool AddBag(Bag bag)
        {
            if(bags.Capacity < maxBag)
            {
                bags.Add(bag);
                return true;
            }
            else 
            {
                throw new IndexOutOfRangeException("Limit exceeded");
            }
        }

        public bool RemoveBag(Bag bag)
        {
            if(bags.Contains(bag))
            {
                bags.Remove(bag);
                return true;
            }
            else
            {
                throw new DllNotFoundException("Object not found");
            }
        }
    }
}