package org.example;

import org.example.dao.*;
import org.example.db.Database;
import org.example.db.ReadSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private ReadSQL fileSQL = new ReadSQL();
    private Connection connection;
    private Statement statement;
    private String select;
    private ResultSet resultSet;

    public DatabaseQueryService() {
        connection = Database.getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> maxProjectCountClientArrayList = new ArrayList<>();
        select = fileSQL.getSQL("find_max_projects_client.sql");
        try {
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                maxProjectCountClient.setName(resultSet.getString("NAME"));
                maxProjectCountClient.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                maxProjectCountClientArrayList.add(maxProjectCountClient);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxProjectCountClientArrayList;
    }

    List<LongestProject> findLongestProject() {
        List<LongestProject> LongestProjectList = new ArrayList<>();
        select = fileSQL.getSQL("find_longest_project.sql");
        try {
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject();
                longestProject.setId(resultSet.getInt("id"));
                longestProject.setMonth_count(resultSet.getInt("MONTH_COUNT"));

                LongestProjectList.add(longestProject);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return LongestProjectList;
    }

    List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<>();
        select = fileSQL.getSQL("find_max_salary_worker.sql");
        try {
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
                maxSalaryWorker.setName(resultSet.getString("name"));
                maxSalaryWorker.setSalary(resultSet.getInt("salary"));

                maxSalaryWorkerList.add(maxSalaryWorker);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxSalaryWorkerList;
    }

    List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> youngestEldestWorkersList = new ArrayList<>();
        select = fileSQL.getSQL("find_youngest_eldest_workers.sql");
        try {
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                YoungestEldestWorkers youngestEldestWorkers = new YoungestEldestWorkers();
                youngestEldestWorkers.setType(resultSet.getString("TYPE"));
                youngestEldestWorkers.setName(resultSet.getString("name"));
                youngestEldestWorkers.setBirthday(resultSet.getDate("birthday").toLocalDate());

                youngestEldestWorkersList.add(youngestEldestWorkers);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return youngestEldestWorkersList;
    }

    List<ProjectPrices> printProjectPrices() {
        List<ProjectPrices> projectPricesList = new ArrayList<>();
        select = fileSQL.getSQL("print_project_prices.sql");
        try {
            resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                ProjectPrices projectPrices = new ProjectPrices();
                projectPrices.setId(resultSet.getInt("project_id"));
                projectPrices.setPrice(resultSet.getInt("PRICE"));

                projectPricesList.add(projectPrices);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projectPricesList;
    }
}
