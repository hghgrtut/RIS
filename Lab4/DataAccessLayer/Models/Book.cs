using System.ComponentModel.DataAnnotations;

namespace Lab7.DataAccess.Models;

public class Book
{
    [Key] public Guid Id { get; set; }
    [Required] public string Title { get; set; }
    [Required] public string Description { get; set; }
}