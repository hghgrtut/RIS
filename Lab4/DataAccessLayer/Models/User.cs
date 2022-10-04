using System.ComponentModel.DataAnnotations;

namespace Lab7.DataAccess.Models;

public class User
{
    [Key] public Guid Id { get; set; }
    [Required] public string FirstName { get; set; }
    [Required] public string LastName { get; set; }
}