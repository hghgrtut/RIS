using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ammunition
{
    public interface IMotorcyclist
    {
        double GetPriceAmmunition();
        bool PutAmmunition(Ammunition ammunition);
        bool RemoveAmmunition(Ammunition ammunition);
    }
}