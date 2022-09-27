using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GrpcServer.Models
{
    public class Train
    {
        public string model {get; set;}
        public int maxCarriage {get; set;}
        private int countPeople;
        private int countBag;
        public List<Carriage> carriages {get;}

    public Train(string model, int maxCarriage)
        {
            this.model = model;
            this.maxCarriage = maxCarriage;
            this.countPeople = 0;
            this.countBag = 0;
            this.carriages = new List<Carriage>();
        }

         public int GetCountPerson()
        {
            foreach(Carriage carriage in carriages)
            {
                countPeople += carriage.people.Capacity;
            }
            return countPeople;
        }

        public int GetCountBag()
        {
            foreach(Carriage carriage in carriages)
            {
                countBag += carriage.bags.Capacity;
            }
            return countBag;
        }

        public bool AddCarriage(Carriage carriage)
        {
            if(carriages.Capacity < maxCarriage)
            {
                carriages.Add(carriage);
                return true;
            }
            else
            {
                throw new IndexOutOfRangeException("Limit exceeded");
            }
        }
    }
}