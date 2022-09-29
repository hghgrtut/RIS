using System.ComponentModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ammunition
{
    [Serializable]
    public class Motorcyclist : IMotorcyclist
    {

        public string name {get; set;}
        public List<Ammunition> ammunitions {get; set;}

        public Motorcyclist(string name)
        {
            this.name = name;
            this.ammunitions = new List<Ammunition>();
        }

        public bool PutAmmunition(Ammunition ammunition)
        {
            if(!ammunitions.Contains(ammunition))
            {
                ammunitions.Add(ammunition);
                return true;
            } 
            else
            {
                return false;
            }
        }

        public bool RemoveAmmunition(Ammunition ammunition)
        {
            if(ammunitions.Contains(ammunition))
            {
                ammunitions.Add(ammunition);
                return true;
            }
            else
            {
                return false;
            }
        }
        
        public double GetPriceAmmunition()
        {
            double price = 0;
            foreach(Ammunition ammunition in ammunitions)
            {
                price += ammunition.price;
            }
            return price;
        }

    }
}