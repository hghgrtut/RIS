using System.Transactions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GrpcServer.Models;

namespace GrpcServer.Services
{
    public class TrainService : Train.TrainBase
    {
        public Models.Train train{get; set;}

        //Заглушка
        public TrainService()
        {
            Person person = new("Mira", "Varel");
            Bag bag = new(person);

            Carriage carriage = new ("PASSENGER", 1, 1);
            carriage.RegistrationPerson(person);
            carriage.AddBag(bag);

             this.train = new ("R8", 2);
            train.AddCarriage(carriage);
        }
        

        public override Task<ResponseCountePeople> GetCountPeople(Request request, Grpc.Core.ServerCallContext context)
        {

            return Task.FromResult(new ResponseCountePeople
            {
                CountPeople = train.GetCountPerson()
            });
        }

        public override Task<ResponseCountBag> GetCountBag(Request request, Grpc.Core.ServerCallContext context)
        {
            return Task.FromResult(new ResponseCountBag
            {
                CountBag = train.GetCountBag()
            });
        }
    }
}