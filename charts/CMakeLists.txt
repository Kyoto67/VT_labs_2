cmake_minimum_required(VERSION 3.24)
project(charts)

include(FetchContent)

set(CMAKE_CXX_STANDARD 17)

find_package(Matplot++ QUIET)
if(NOT Matplot++_FOUND)
    FetchContent_Declare(matplotplusplus
            GIT_REPOSITORY https://github.com/alandefreitas/matplotplusplus
            GIT_TAG origin/master) # or whatever tag you want
    FetchContent_GetProperties(matplotplusplus)
    if(NOT matplotplusplus_POPULATED)
        FetchContent_Populate(matplotplusplus)
        add_subdirectory(${matplotplusplus_SOURCE_DIR} ${matplotplusplus_BINARY_DIR} EXCLUDE_FROM_ALL)
    endif()
endif()

add_executable(charts main.cpp)
target_link_libraries(charts PUBLIC matplot)
