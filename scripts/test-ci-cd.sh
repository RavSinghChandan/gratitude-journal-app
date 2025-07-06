#!/bin/bash

# Test CI/CD Setup Script
# This script helps test the CI/CD pipeline components locally
#cd /Users/chandankumar/Desktop/workspace/gratitude-journal-app && chmod +x scripts/test-ci-cd.sh && ./scripts/test-ci-cd.sh
set -e

echo "🧪 Testing CI/CD Setup for Gratitude Journal App"
echo "================================================"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

# Function to print colored output
print_status() {
    echo -e "${GREEN}✅ $1${NC}"
}

print_warning() {
    echo -e "${YELLOW}⚠️  $1${NC}"
}

print_error() {
    echo -e "${RED}❌ $1${NC}"
}

# Check if required tools are installed
check_dependencies() {
    echo "Checking dependencies..."
    
    # Check Node.js
    if command -v node &> /dev/null; then
        NODE_VERSION=$(node --version)
        print_status "Node.js found: $NODE_VERSION"
    else
        print_error "Node.js not found. Please install Node.js 18+"
        exit 1
    fi
    
    # Check npm
    if command -v npm &> /dev/null; then
        NPM_VERSION=$(npm --version)
        print_status "npm found: $NPM_VERSION"
    else
        print_error "npm not found"
        exit 1
    fi
    
    # Check Java
    if command -v java &> /dev/null; then
        JAVA_VERSION=$(java -version 2>&1 | head -n 1)
        print_status "Java found: $JAVA_VERSION"
    else
        print_error "Java not found. Please install Java 21+"
        exit 1
    fi
    
    # Check Maven (optional - we can use Maven wrapper)
    if command -v mvn &> /dev/null; then
        MVN_VERSION=$(mvn --version | head -n 1)
        print_status "Maven found: $MVN_VERSION"
    else
        print_warning "Maven not found globally, will use Maven wrapper (mvnw)"
    fi
    
    # Check Maven wrapper
#    if [ -f "graitude-journal-back-end/mvnw" ]; then
#        print_status "Maven wrapper (mvnw) found"
#    else
#        print_error "Maven wrapper not found in backend directory"
#        exit 1
#    fi
    
    # Check Docker (optional)
    if command -v docker &> /dev/null; then
        DOCKER_VERSION=$(docker --version)
        print_status "Docker found: $DOCKER_VERSION"
    else
        print_warning "Docker not found. Docker builds will be skipped"
    fi
}

# Test Frontend
test_frontend() {
    echo ""
    echo "Testing Frontend (Angular)..."
    
    cd gratitude-journal-front-end/gratitude-jounal-ui
    
    # Install dependencies
    print_status "Installing frontend dependencies..."
    npm ci
    
    # Run linting
    print_status "Running linting..."
    npm run lint || print_warning "Linting completed with warnings"
    
    # Run tests
    print_status "Running frontend tests..."
    npm run test -- --watch=false --browsers=ChromeHeadless
    
    # Build
    print_status "Building frontend..."
    npm run build -- --configuration production
    
    print_status "Frontend tests completed successfully!"
    cd ../..
}

# Test Backend
test_backend() {
    echo ""
    echo "Testing Backend (Spring Boot)..."
    
    cd graitude-journal-back-end
    
    # Run tests using Maven wrapper
    print_status "Running backend tests..."
    ./mvnw clean test -B
    
    # Build using Maven wrapper
    print_status "Building backend..."
    ./mvnw clean package -B -DskipTests
    
    print_status "Backend tests completed successfully!"
    cd ..
}

# Test Docker Build (if Docker is available)
test_docker() {
    if command -v docker &> /dev/null; then
        echo ""
        echo "Testing Docker Build..."
        
        cd graitude-journal-back-end
        
        print_status "Building Docker image..."
        docker build -t gratitude-journal-backend:test .
        
        print_status "Docker build completed successfully!"
        cd ..
    else
        print_warning "Skipping Docker test (Docker not available)"
    fi
}

# Check GitHub Actions files
check_workflows() {
    echo ""
    echo "Checking GitHub Actions workflows..."
    
    if [ -f ".github/workflows/frontend-ci-cd.yml" ]; then
        print_status "Frontend CI/CD workflow found"
    else
        print_error "Frontend CI/CD workflow not found"
    fi
    
    if [ -f ".github/workflows/backend-ci-cd.yml" ]; then
        print_status "Backend CI/CD workflow found"
    else
        print_error "Backend CI/CD workflow not found"
    fi
    
    if [ -f ".github/workflows/full-stack-ci-cd.yml" ]; then
        print_status "Full-stack CI/CD workflow found"
    else
        print_error "Full-stack CI/CD workflow not found"
    fi
}

# Main execution
main() {
    echo "Starting CI/CD setup test..."
    
    check_dependencies
    check_workflows
    test_frontend
    test_backend
    test_docker
    
    echo ""
    echo "🎉 All tests completed successfully!"
    echo ""
    echo "Next steps:"
    echo "1. Push your code to GitHub"
    echo "2. Add required secrets to your repository"
    echo "3. Set up environments (development/production)"
    echo "4. Configure branch protection rules"
    echo ""
    echo "For detailed setup instructions, see CI-CD-README.md"
}

# Run main function
main "$@" 