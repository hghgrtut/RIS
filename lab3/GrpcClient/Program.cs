using Grpc.Net.Client; 
using System;
using System.Threading.Tasks;

namespace GrpcClient
{
    class Program
    {
        static async Task Main(string[] args)
        {
           using var channel = GrpcChannel.ForAddress("http://localhost:5152");
           var clinet = new Train.TrainClient(channel);

           var responsePeople = await clinet.GetCountPeopleAsync(new Request());

           Console.WriteLine("Количество людей: " + responsePeople.CountPeople);

           var responseBag = await clinet.GetCountBagAsync(new Request());

           Console.WriteLine("Количество багажа: " + responseBag.CountBag);


        }
    }
    
}