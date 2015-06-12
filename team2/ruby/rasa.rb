#!/usr/bin/env ruby

ARGV.each do|a|
  content = ''
  File.open(a).each do |line|
    content += line
  end
  lines = 0
  complexity = 0
  depth = 1
  content.split("").each do |i|
    if i == "{"
      depth = depth + 1
    end
    if i == "}"
      depth = depth - 1
    end
    if i == ";"
      complexity = complexity + depth
    end
    if i == "\n"
      lines = lines + 1
    end
  end
  puts "file #{a}: lines: #{lines} RaSa: #{complexity}"
end
