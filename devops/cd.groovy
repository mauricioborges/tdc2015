node {
  echo "### VERSION CONTROL"
  git url: "https://github.com/mauricioborges/cuke-gradle-demo.git"
  echo "### BUILD AND UNIT TESTS"
  try {
     sh "./gradlew test"
  } finally {
     step([$class: 'JUnitResultArchiver', testResults: '**/build/test-results/TEST-*.xml'])
  }
}
echo "### AUTOMATED ACCEPTANCE TESTS"
def automatedAcceptanceTests = [:]

automatedAcceptanceTests[functional]=node {
  sh "./gradlew cucumber_functional"
}
automatedAcceptanceTests[ui]=node {
  sh "./gradlew cucumber_UI"
}
parallel automatedAcceptanceTests
echo "### USER ACCEPTANCE TESTS"
input "are all of your tests ok?"
echo "### RELEASE!!!"
input "can I release everything?"