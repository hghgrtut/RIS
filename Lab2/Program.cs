using System;

namespace ammunition
{
    class Program
    {
        public static void Main(string[] args)
        {
            Ammunition ammunitionHelmet = new(TypeAmmunition.Helmet, "LS2 OF562 Airflow Solid Matt Black", 202);
            Ammunition ammunitionJacket = new(TypeAmmunition.Jacket, "OZONE DART LADY BLACK", 243);
            Ammunition ammunitionGloves = new(TypeAmmunition.Gloves, "SECA FREE", 67);

            Motorcyclist motorcyclist = new("Victoria");
            motorcyclist.PutAmmunition(ammunitionHelmet);
            motorcyclist.PutAmmunition(ammunitionJacket);
            motorcyclist.PutAmmunition(ammunitionGloves);

            ObjectSerializable objectSerializable = new();

            objectSerializable.SerializableToFile("temp", motorcyclist);

            Motorcyclist motorcyclistNew =  objectSerializable.DeserializeFromFile("temp");


            Console.WriteLine(motorcyclistNew.GetPriceAmmunition());
        }
    }
}