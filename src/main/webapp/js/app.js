var lastfmApp = angular.module('lastfmApp', []);

lastfmApp.controller('fetchArtistController', function($scope, $http) {

    $scope.main = {
        page: 1
    };
    $scope.searchArtist = function() {
        $http({method: 'GET',
            params: {start : $scope.startPosition},
            url: 'http://localhost:8080//LastFmRedBallon/rest/lastfm/artists/'+$scope.country+'?start='+$scope.main.page}).
        then(function(response) {
            if (response.data == null) {
                $scope.message = "No artist found";
            } else {
                $scope.results = response.data;
                $scope.message = "";
            }
        });
    }

    $scope.nextPage = function() {
        $scope.main.page++;
        $scope.searchArtist();
    };

    $scope.previousPage = function() {
        if ($scope.main.page > 1) {
            $scope.main.page--;
            $scope.searchArtist();
        }
    };
});
			
		 
