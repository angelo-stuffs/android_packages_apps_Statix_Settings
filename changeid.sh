#!/bin/bash

generate_change_id() {
  local tree=$(git write-tree)
  local parent=$(git rev-parse HEAD 2>/dev/null || echo "0000000000000000000000000000000000000000")
  local author=$(git var GIT_AUTHOR_IDENT)
  local message=$(git log -1 --pretty=%B)

  echo -n "I"
  echo -n "$tree $parent $author $message" | sha1sum | awk '{print $1}'
}

add_change_id() {
  local change_id=$(generate_change_id)
  git commit --amend -m "$(git log -1 --pretty=%B)

Change-Id: $change_id"
}

add_change_id
