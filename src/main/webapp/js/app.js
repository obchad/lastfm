var lastfmApp = angular.module('lastfmApp', []);

lastfmApp.controller('lastfmController', function ($scope, $http) {
    $http.get('http://localhost:8080/rest/lastfm/findall')
        .then(function (response) {
            $scope.result = response.data;
        });

});

lastfmApp.controller('fetchArtistController', function ($scope, $http) {
    $scope.searchArtist = function () {
        $http({
            method: 'GET',
            params: {country: $scope.country},
            url: 'http://localhost:8080/rest/lastfm/artists'
        }).then(function (response) {
            if (response.data == null) {
                $scope.message = "No artist found";
            } else {
                $scope.results = response.data;
                $scope.message = "";
            }

        });
    }
});
			
		 
