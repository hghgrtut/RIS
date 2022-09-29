using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ammunition
{
    [Serializable]
    public class Ammunition
    {
        public TypeAmmunition typeAmmunition {get; set;}
        public string model {get; set;}
        public double price {get; set;}

        public Ammunition(TypeAmmunition typeAmmunition, string model, double price)
        {
            this.typeAmmunition = typeAmmunition;
            this.model = model;
            this.price = price;
        }
    }
}