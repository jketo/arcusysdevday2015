class Calculate
  def initialize(file)
    @res = calculate(file)
    puts "#{file}: lines #{res[0]}, RaSa: #{res[1]}"
  end

  def res
    @res
  end

  def calculate(file, dept = 1, sum = 0, lines = 0)
    File.open(file, "r") do |infile|
      while (line = infile.gets)
        lines += 1
        line.each_char do |sym|
          dept += 1 if(sym == '{')
          dept -= 1 if(sym == '}')
          sum += dept if (sym == ';')
        end
      end
      res = [lines, sum] of Int32
    end
  end
end

lines = rasa = 0
ARGV.each do |f|
  c = Calculate.new(f)
  res = c.res
  lines += res[0]; rasa += res[1]
end
puts "Total: lines #{lines}, RaSa: #{rasa}"