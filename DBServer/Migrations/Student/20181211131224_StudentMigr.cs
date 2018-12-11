using Microsoft.EntityFrameworkCore.Migrations;

namespace DBServer.Migrations.Student
{
    public partial class StudentMigr : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Students",
                columns: table => new
                {
                    StudentId = table.Column<string>(nullable: false),
                    Password = table.Column<string>(nullable: true),
                    StudentName = table.Column<string>(nullable: true),
                    StudentAdress = table.Column<string>(nullable: true),
                    StudentPhoneNo = table.Column<string>(nullable: true),
                    StudentEmail = table.Column<string>(nullable: true),
                    StudentBankAcc = table.Column<string>(nullable: true),
                    StudentMonthWorkedHours = table.Column<double>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Students", x => x.StudentId);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Students");
        }
    }
}
