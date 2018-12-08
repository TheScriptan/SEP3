using Microsoft.EntityFrameworkCore.Migrations;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

namespace DBServer.Migrations.Student
{
    public partial class InitialStudentCreate : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Students",
                columns: table => new
                {
                    StudentId = table.Column<long>(nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.SerialColumn),
                    Password = table.Column<string>(nullable: true),
                    StudentName = table.Column<string>(nullable: true),
                    StudentAdress = table.Column<string>(nullable: true),
                    StudentPhoneNo = table.Column<int>(nullable: false),
                    StudentEmail = table.Column<string>(nullable: true),
                    StudentBankAcc = table.Column<int>(nullable: false),
                    StudentMonthWorkedHours = table.Column<int>(nullable: false)
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
