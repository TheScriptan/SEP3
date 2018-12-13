﻿// <auto-generated />
using System;
using DBServer.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

namespace DBServer.Migrations
{
    [DbContext(typeof(CompanyContext))]
    [Migration("20181213134855_InitialCreate")]
    partial class InitialCreate
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.SerialColumn)
                .HasAnnotation("ProductVersion", "2.1.2-rtm-30932")
                .HasAnnotation("Relational:MaxIdentifierLength", 63);

            modelBuilder.Entity("DBServer.Models.Company", b =>
                {
                    b.Property<long>("CompanyId")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("CompanyAdress");

                    b.Property<string>("CompanyEmail");

                    b.Property<string>("CompanyName");

                    b.Property<string>("CompanyPhone");

                    b.HasKey("CompanyId");

                    b.ToTable("Companies");
                });

            modelBuilder.Entity("DBServer.Models.CompleteShift", b =>
                {
                    b.Property<long>("ShiftDoneId")
                        .ValueGeneratedOnAdd();

                    b.Property<long>("CompanyId");

                    b.Property<long>("ShiftId");

                    b.Property<string>("StudentId");

                    b.Property<DateTime>("checkIn");

                    b.Property<DateTime>("checkOut");

                    b.HasKey("ShiftDoneId");

                    b.ToTable("CompleteShifts");
                });

            modelBuilder.Entity("DBServer.Models.Employee", b =>
                {
                    b.Property<string>("EmployeeId")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("EmployeeAdress");

                    b.Property<string>("EmployeeBankAcc");

                    b.Property<string>("EmployeeEmail");

                    b.Property<double>("EmployeeMonthWorkedHours");

                    b.Property<string>("EmployeeName");

                    b.Property<string>("EmployeePhoneNo");

                    b.Property<string>("Password");

                    b.HasKey("EmployeeId");

                    b.ToTable("Employees");
                });

            modelBuilder.Entity("DBServer.Models.Shift", b =>
                {
                    b.Property<long>("ShiftId")
                        .ValueGeneratedOnAdd();

                    b.Property<long>("CompanyId");

                    b.Property<DateTime>("ShiftDate");

                    b.Property<string>("ShiftRequirements");

                    b.Property<double>("ShiftTime");

                    b.HasKey("ShiftId");

                    b.ToTable("Shifts");
                });
#pragma warning restore 612, 618
        }
    }
}
