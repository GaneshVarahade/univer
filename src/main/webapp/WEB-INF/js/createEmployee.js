/**
 * 
 */
function Hello($scope, $http) {
    $http.get('http://localhost:8080/SpringRestCrud/employee/list').
        success(function(data) {
            $scope.list = data;
        });
}

