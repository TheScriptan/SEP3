using Microsoft.EntityFrameworkCore.Migrations;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;
using System;

namespace VikarDb.Migrations
{
    public partial class initial : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Shift", 
                columns: table => new
                {
                    ShiftId = table.Column<long>(nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.SerialColumn),
                    CompanyId = table.Column<long>(nullable: true),
                    ShiftDate = table.Column<DateTime>(nullable: false),
                    ShiftTime = table.Column<int>(nullable: false),
                    ShiftRequirements = table.Column<string>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Shift", x => x.ShiftId);
                   /*  table.ForeignKey("FK_Shift", x => x.CompanyId);*/
                });
            migrationBuilder.CreateTable(
                name: "Company", 
                columns: table => new
                {
                    CompanyId = table.Column<long>(nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.SerialColumn),
                    CompanyName = table.Column<string>(nullable: false),
                    CompanyAdress = table.Column<string>(nullable: false),
                    CompanyPhone = table.Column<int>(nullable: false),
                    CompanyEmail = table.Column<string>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Company", y => y.CompanyId);
                   /*  table.ForeignKey("FK_Shift", x => x.CompanyId);*/
                });
             migrationBuilder.CreateTable(
                name: "Employee", 
                columns: table => new
                {
                    EmployeeId = table.Column<long>(nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.SerialColumn),
                    Password = table.Column<long>(nullable: true),
                    EmployeeName = table.Column<string>(nullable: false),
                    EmployeeAdress = table.Column<string>(nullable: false),
                    EmployeePhoneNo = table.Column<int>(nullable: false),
                    EmployeeEmail = table.Column<string>(nullable: false),
                    EmployeeBankAcc = table.Column<string>(nullable: false),
                    EmployeeMonthWorkedHours = table.Column<int>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Employee", w => w.EmployeeId);
                   /*  table.ForeignKey("FK_Shift", x => x.CompanyId);*/
                });
            migrationBuilder.CreateTable(
                name: "CompleteShift", 
                columns: table => new
                {
                    ShiftDoneId = table.Column<long>(nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.SerialColumn),
                    ShiftId = table.Column<long>(nullable: false),
                    CompanyId = table.Column<long>(nullable: false),
                    StudentId = table.Column<long>(nullable: false),
                    Status = table.Column<string>(nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_CompleteShift", z => z.ShiftDoneId);
                   /*  table.ForeignKey("FK_Shift", x => x.CompanyId);*/
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Shift");
            migrationBuilder.DropTable(
                name: "Employee");
            migrationBuilder.DropTable(
                name: "Company");
            migrationBuilder.DropTable(
                name: "CompleteShift");
        }
    }
}
