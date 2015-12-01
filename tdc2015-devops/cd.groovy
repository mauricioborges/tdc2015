stage name: 'Build and Unit Tests'

node {
  git url: "https://github.com/mauricioborges/cuke-gradle-demo.git"
  try {
     sh "./gradlew clean test"
  } finally {
     step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/TEST-*.xml'])
  }
}

stage name: 'Automated Acceptance Tests', concurrency: 3 //avoid overloading
/*def automatedAcceptanceTests = [:]

automatedAcceptanceTests[functional]=node {
  git url: "https://github.com/mauricioborges/cuke-gradle-demo.git"
  sh "./gradlew cucumber_functional"
}
automatedAcceptanceTests[ui]=node {
  git url: "https://github.com/mauricioborges/cuke-gradle-demo.git"
  sh "./gradlew cucumber_UI"
}
parallel automatedAcceptanceTests
*/
stage name: 'User Acceptance Tests'
input "are all of your tests ok?"

stage name: 'Production', concurrency: 1
input "can I release everything?"
echo 'Imagine that I\'m running very complex deploying processes here!'
sleep 45
echo "it's over, your version is running...go home"