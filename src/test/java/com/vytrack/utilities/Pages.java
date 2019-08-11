package com.vytrack.utilities;

import com.vytrack.pages.activites.CalendarEventsPage;
import com.vytrack.pages.activites.FleetVehiclesPage;
import com.vytrack.pages.dashboards.DashboardPage;
import com.vytrack.pages.dashboards.ManageDashboards;
import com.vytrack.pages.login_navigation.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private CalendarEventsPage calendarEventsPage;
    private DashboardPage dashboardPage;
    private ManageDashboards manageDashboards;
    private FleetVehiclesPage fleetVehiclesPage;


    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CalendarEventsPage calendarEventsPage() {
        if (calendarEventsPage == null) {
            calendarEventsPage = new CalendarEventsPage();
        }
        return calendarEventsPage;
    }

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ManageDashboards manageDashboards() {
        if (manageDashboards == null) {
            manageDashboards = new ManageDashboards();
        }
        return manageDashboards;
    }

    public FleetVehiclesPage fleetActivitiesPage() {
        if(fleetVehiclesPage == null) {
            fleetVehiclesPage = new FleetVehiclesPage();
        }
        return fleetVehiclesPage;
    }
}
