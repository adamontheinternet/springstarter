angular.module('hello', [])
    .controller('home', function($scope, $http) {
        $http.get('/greetings?name=MrAdam').success(function(data) {
            $scope.greeting = data;
        })
    });