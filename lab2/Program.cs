using System.Data;
namespace lab2
{
    public class Program
    {
        public static void Main()
        {
            Person person = new("Coco", "Milk");
            Bag bag = new(person);

            Carriage carriage = new (TypeCarriage.PASSENGER, 1, 1);
            carriage.RegistrationPerson(person);
            carriage.AddBag(bag);
            
            Train train = new ("R8", 2);
            train.AddCarriage(carriage);


            ObjectSerializable objectSerializable = new();

            objectSerializable.SerializableToFile("test", train);

            Train newTrain = objectSerializable.DeserializeFromFile("test");          


        }
    }
}