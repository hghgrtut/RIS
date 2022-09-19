using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace lab2
{
    public interface ICarriage
    {
        bool RegistrationPerson(Person person);
        bool RefuseRegistrationPerson(Person person);
        bool AddBag(Bag bag);
        bool RemoveBag(Bag bag);


    }
}