using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace lab2
{
    public interface ITrain
    {
        bool AddCarriage(Carriage carriage);
        int GetCountPerson();
        int GetCountBag();

    }
}